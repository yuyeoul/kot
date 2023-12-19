<template>
    <div class="container">
        <div class="avobe-ranking-plate">
            <!-- <div class="gender-select nav nav-tabs" v-show="$route.name !== 'search'">
                <li class="nav-item"><RouterLink to="/" class="nav-link active">남자</RouterLink></li>
                <li class="nav-item"><RouterLink to="/female" class="nav-link">여자</RouterLink></li>
            </div> -->
            <div class="search-area">
                <input type="text" v-model="search" placeholder="검색할 사용자의 이름을 입력하세요." @keyup.enter="goSearch()">
                <button class="btn btn-success" @click="goSearch">검색</button>
            </div>
        </div>
        <div class="ranking-plate">
            <RouterView />
        </div>
    </div>
</template>

<script setup>
import { useUserStore } from "@/stores/user";
import { onMounted, ref } from "vue";

const store = useUserStore()
const search = ref("")

const goSearch = function() {
    // store.getMaleUser()
    // store.getFemaleUser()
    store.getSearchResult(search.value)
}

</script>

<style scoped>
.avobe-ranking-plate {
    display: flex;
    flex-direction: row-reverse;
    padding: 5px;
}

.search-area input {
    margin: 5px;
    vertical-align: middle;
}
.search-area button {
    margin: 5px;
}

/* .search-area {
    display: flex;
    flex-direction: row;
    justify-content: center;
} */

input {
  border: 0;
  background-color: lightgray;
  border-radius: 5px;
  padding: 3px 10px;
  width: 350px;
  height: 38px;
}

</style>