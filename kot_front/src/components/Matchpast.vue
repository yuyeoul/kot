<template>
    <div>
        <h2>과거 매칭기록</h2>
        <div v-if="store.pastMatching.length != 0" class="past-matching-result">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>날짜</th>
                        <th>상대방</th>
                        <th>경기결과</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="match in store.pastMatching" :key="match">
                        <td>{{ formatDate(match.fDate) }}</td>
                        <td v-if="checkOpponent(match.user1)">{{ match.user1Name }}({{ match.user1 }})</td>
                        <td v-else>{{ match.user2Name }}({{ match.user2 }})</td>
                        <td v-if="checkOpponent(match.user1)">{{ matchWinner(match.user1, match.result) }}</td>
                        <td v-else>{{ matchWinner(match.user2, match.result) }}</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div v-else class="no-past-matching-result">
            <h2>과거 매칭기록이 없어요!</h2>
        </div>
        
    </div>
</template>

<script setup>
import { useUserStore } from "@/stores/user";
import { onBeforeMount, onMounted, ref } from "vue";

const store = useUserStore()

const formatDate = function (matchDate) {
    const newMatchDate = new Date(matchDate);
    return newMatchDate.toLocaleDateString();
}

const checkOpponent = function (str) {
    if (store.myId == str) {
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



onBeforeMount(() => {
    store.getPastMatching()
}),

onMounted(() => {

})
</script>

<style scoped>
h2 {
    font-family: MaplestoryLight;
}
.no-past-matching-result {
    margin-top: 80px;
    text-align: center;
    font-family: MaplestoryLight;
}
</style>