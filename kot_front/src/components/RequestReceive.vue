<template>
    <div>
        <div v-show="store.receivedRequestList.length > 0">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>날짜</th>
                        <th>요청 보낸 사람</th>
                        <th>수락/거절</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="receive in store.receivedRequestList" :key="receive.sender" @click="store.beforeGetOneUser(receive.sender)">
                        <td>{{ formatDate(receive.mdate) }}</td>
                        <td>{{ receive.senderName }}({{ receive.sender }})</td>
                        <td>
                            <button class="btn btn-success" @click="matchSuccess(receive)">수락</button>&nbsp;
                            <button class="btn btn-danger" @click="matchDecline(receive)">거절</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div v-show="store.receivedRequestList.length == 0">
            <h2>받은 요청이 없어요!</h2>
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

const matchSuccess = function (receive) {
    event.stopPropagation();
    // update
    const match = {
        receiver: JSON.parse(localStorage.getItem('loginUser')).loginId,
        sender: receive.sender,
    }

    const loginUserId = JSON.parse(localStorage.getItem('loginUser')).loginId

    axios.put("http://localhost:8080/wait", match).then((res) => {
        alert("매칭이 수락되었습니다.");

        // delete
        axios.delete("http://localhost:8080/wait/"+loginUserId).then((delres) => {

        })
        axios.put("http://localhost:8080/wait/start", match).then((ress)=>{
            
        })

    })

    const result = {
        user1: receive.receiver,
        user2: receive.sender,
        matchDate: new Date(),
        user1Phone: receive.user1Phone,
        user2Phone: receive.user2Phone,
        user1Name: receive.receiverName,
        user2Name: receive.senderName,
    }

    axios.post("http://localhost:8080/result", result).then((insres) => {
        router.push("/now");
    })
}

const matchDecline = function (receive) {
    event.stopPropagation();
    axios.delete("http://localhost:8080/wait/decline/"+receive.sender).then((response) => {
        alert("매칭이 거절되었습니다.");
        router.go(0)
    })

}

const formatDate = function (matchDate) {
    const newMatchDate = new Date(matchDate);
    return newMatchDate.toLocaleDateString();
}

onMounted(() => {
    store.getReceivedRequestList()
})
</script>

<style scoped>
a:hover {
    background: linear-gradient(to top, rgb(198, 255, 171) 50%, transparent 50%);
    border-radius: 5px;
}
a {
    display: inline;
    text-decoration: none;
    color: black;
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
    text-align: center;
    font-family: MaplestoryLight;
}
</style>