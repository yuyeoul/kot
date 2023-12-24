<template>
    <div class="flex xl:pt-[4.5rem]">
        <div class="search-area">
                <input type="text" v-model="search" placeholder="검색할 게시글을 입력하세요." @keyup.enter="goSearch()">
                <button class="btn btn-success" @click="goSearch">검색</button>
        </div>
        <router-view></router-view>
    </div>
</template>

<script setup>
import axios from 'axios';
import { useUserStore } from '../stores/user';
import { useBoardStore } from '../stores/board';
import { onBeforeMount, onMounted, ref, computed } from 'vue';
import { useRouter } from "vue-router";
import { RouterView } from "vue-router";

import BoardList from "../components/BoardList.vue";

const store = useUserStore()
const router = useRouter()
const bstore=useBoardStore()


const search = ref("")

const goSearch = function() {
    bstore.getSearchResult(search.value)
}

</script>

<style scoped>
.search-area input {
    margin: 5px;
    vertical-align: middle;
}
.search-area button {
    margin: 5px;
}
input {
  border: 0;
  background-color: lightgray;
  border-radius: 5px;
  padding: 3px 10px;
  width: 350px;
  height: 38px;
}
</style>