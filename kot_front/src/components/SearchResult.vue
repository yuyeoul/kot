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
                    <tr v-for="result in store.searchList" :key="result" @click="userInfo(result)">
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
import { useRouter } from "vue-router";
import axios from 'axios'


const store = useUserStore()
const route = useRoute()
const router = useRouter()
const userInfo =function(result){
    axios.get("http://localhost:8080/user/selectuser",{
      params: {
        loginId:result.loginId,
        gender:result.gender
      }
    }).then((response) => {
      store.oneuser.value = response.data
      router.push("/user")
    })
   
}
onBeforeMount (() => {
    store.getSearchResult(route.params.search)
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