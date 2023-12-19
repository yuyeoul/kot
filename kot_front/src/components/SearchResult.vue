<template>
    <div>
        <h2>검색 결과</h2>
        <div v-if="store.searchList.length != 0" class="search-result">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>이름</th>
                        <th>점수</th>
                        <th>성별</th>
                        <th>매칭현황</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="result in store.searchList" :key="result" @click="store.getOneUser(result)">
                        <td>{{ result.name }}</td>
                        <td>{{ result.rate }}</td>
                        <td>{{ result.gender }}</td>
                        <td v-if="result.status">경기중</td>
                        <td v-else>신청가능</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div v-else class="no-result">
            <h2>검색 결과가 없어요!</h2>
        </div>
    </div>
</template>

<script setup>
import { useUserStore } from "@/stores/user";
import { onBeforeMount, ref } from "vue";
import { useRoute } from "vue-router";

const store = useUserStore()
const route = useRoute()

onBeforeMount (() => {
    store.getSearchResult(route.params.search)
    store.getMaleUser()
    store.getFemaleUser()
})

</script>

<style scoped>
.no-result {
    text-align: center;
    margin-top: 80px;
}

h2 {
    font-family: MaplestoryLight;
}
</style>