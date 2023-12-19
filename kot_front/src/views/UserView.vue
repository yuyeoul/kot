<template>
    <div class="container">
        <table class="my-info table table-hover">
            <thead>
                <tr>
                    <th>순위</th>
                    <th>이름(아이디)</th>
                    <th>성별</th>
                    <td>나이</td>
                    <th>주소</th>
                    <th>점수</th>
                    <th>신청버튼</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>{{ store.oneuser.ranking }}</td>
                    <td>{{ store.oneuser.name }}({{ store.oneuser.loginId }})</td>
                    <td>{{ store.oneuser.gender }}</td>
                    <td>{{ store.oneuser.age }}</td>
                    <td>{{ store.oneuser.address }}</td>
                    <td>{{ store.oneuser.rate }}</td>
                    <td v-if="itsme"><button class="btn btn-secondary" disabled>신청불가</button> *본인에게는 신청할 수 없습니다.</td>
                    <td v-else-if="!genderEqual"><button class="btn btn-secondary" disabled>신청불가</button> *다른 성별의 사용자입니다.</td>
                    <td v-else-if="store.sentRequestList"><button class="btn btn-secondary" disabled @click="goRequest">신청불가</button> *이미 신청한 매칭이 존재합니다.</td>
                    <td v-else-if="amIMatching"><button class="btn btn-secondary" disabled>신청불가</button> *이미 진행중인 경기가 있습니다.</td>
                    <td v-else-if="!store.oneuser.status"><button class="btn btn-success" @click="goRequest">신청하기</button></td>
                    <!--매칭 불가능 상태일 때에는 신청하기 버튼 비활성화-->
                    <td v-else><button class="btn btn-secondary">신청불가</button></td>
                </tr>
            </tbody>
        </table>
        <div class="my-past-game" style="margin: 60px 0 0 0">
            <h3>최근 전적</h3>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>날짜</th>
                        <th>상대 이름</th>
                        <th>경기 결과</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="pastmatch in store.userPastMatching" :key="pastmatch">
                        <td>{{ formatDate(pastmatch.fDate) }}</td>
                        <td v-if="checkOpponent(pastmatch.user1)">{{ pastmatch.user1Name }}({{ pastmatch.user1 }})</td>
                        <td v-else>{{ pastmatch.user2Name }}({{ pastmatch.user2 }})</td>
                        <td v-if="checkOpponent(pastmatch.user1)">{{ matchWinner(pastmatch.user1, pastmatch.result) }}</td>
                        <td v-else>{{ matchWinner(pastmatch.user2, pastmatch.result) }}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>

<script setup>
import axios from "axios"
import { useUserStore } from "@/stores/user";
import { onBeforeMount, onMounted, ref } from "vue";
import { useRouter } from "vue-router";

const store = useUserStore()
const router = useRouter()

const formatDate = function (matchDate) {
    const newMatchDate = new Date(matchDate);
    return newMatchDate.toLocaleDateString();
}

const checkOpponent = function (u) {
    // 상대방일 때 true를 반환
    if (store.oneuser.loginId == u) {
        return false;
    } else {
        return true;
    }
}

const matchWinner = function (opponent, winner) {
    if (opponent == winner) {
        return "패"
    } else {
        return "승";
    }
}

const genderEqual = ref(false);
const genderCheck = function () {
    if (store.oneuser.gender == JSON.parse(localStorage.getItem('loginUser')).gender) {
        genderEqual.value = true;
    } else {
        genderEqual.value = false;
    }
}

const amIMatching = ref(false);
const checkMyMatching = function () {
    axios.get("http://localhost:8080/user/"+JSON.parse(localStorage.getItem('loginUser')).loginId).then((response) => {
        amIMatching.value = response.data.status;
    })
}

const itsme = ref(false);
const checkIfItsMe = function () {
    if (store.oneuser.loginId == JSON.parse(localStorage.getItem('loginUser')).loginId) {
        itsme.value = true;
    } else {
        itsme.value = false;
    }
}

const goRequest = function () {
    const match = {
        receiver: store.oneuser.loginId,
        sender: JSON.parse(localStorage.getItem('loginUser')).loginId,
        status: false,
        match: false,
        mdate: new Date(),
        user1Phone: store.oneuser.phone,
        user2Phone: JSON.parse(localStorage.getItem('loginUser')).phone,
        receiverName: store.oneuser.name,
        senderName: JSON.parse(localStorage.getItem('loginUser')).name,
        
    }

    axios.post("http://localhost:8080/wait", match).then((res) => {
	alert("매칭 신청이 완료되었습니다.");
    router.push("/send");
  });
};
onBeforeMount(() => {
    store.getSentRequestList();
    store.getUserPastMatching();
}),
onMounted(() => {
    genderCheck();
    checkMyMatching();
    checkIfItsMe();
})
</script>

<style scoped>
    td {
        vertical-align: middle;
    }

    h3 {
        font-family: MaplestoryLight;
    }
</style>