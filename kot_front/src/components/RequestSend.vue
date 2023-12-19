<template>
    <div>
        <div v-show="store.sentRequestList.length > 0">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>날짜</th>
                        <th>요청 받는 사람</th>
                        <th>매칭 신청 취소</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="send in store.sentRequestList" :key="send" @click="store.beforeGetOneUser(send.receiver)">
                        <td>{{ formatDate(send.mdate) }}</td>
                        <td>{{ send.receiverName }}({{ send.receiver }})</td>
                        <td><button class="btn btn-danger" @click="matchDecline(send)">취소</button></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div v-show="store.sentRequestList.length == 0" class="no-contents">
            <h2>보낸 요청이 없어요!</h2>
            <div id="make-inline">
                <RouterLink to="/">신청해볼까?</RouterLink>
            </div>
        </div>
    </div>
</template>

<script setup>
import axios from "axios"
import { useUserStore } from "@/stores/user";
import { onMounted, ref } from "vue";
import { useRouter } from "vue-router";

const store = useUserStore()
const router = useRouter()

const matchDecline = function (send) {
    event.stopPropagation();

    axios.delete("http://localhost:8080/wait/decline/"+send.sender).then((response) => {
        alert("신청이 취소되었습니다.");
        router.push("/")
    })

}

const formatDate = function (matchDate) {
    const newMatchDate = new Date(matchDate);
    return newMatchDate.toLocaleDateString();
}

onMounted(() => {
    store.getSentRequestList()
})
</script>

<style scoped>
a {
  color: black;
  text-decoration: none;
  background: linear-gradient(to top, rgb(198, 255, 171) 50%, transparent 50%);
}

a:hover {
  background: linear-gradient(to top, rgb(218, 255, 201) 50%, transparent 50%);
  border-radius: 5px;
}
.custom-link.router-link-exact-active {
    background: linear-gradient(to top, rgb(198, 255, 171) 50%, transparent 50%);
    border-radius: 5px;
}

td {
    vertical-align: middle;
}

h2 {
    margin-top: 80px;
    font-family: MaplestoryLight;
}

.no-contents {
    text-align: center; 
}
</style>