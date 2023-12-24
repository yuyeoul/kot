<template>
 <div>
    <h2>검색 결과</h2>
        <div v-if="bstore.searchList.length != 0" class="search-result">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>글번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>작성날짜</th>
                        <th>조회수</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="result in bstore.searchList" :key="result" @click="bstore.getOneArticle(result)">
                        <td>{{ result.boardId }}</td>
                        <td>{{ result.title }}</td>
                        <td>{{ result.userId }}</td>
                        <td>{{ result.regdate }}</td>
                        <td>{{ result.view }}</td>
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
import axios from 'axios';
import { useUserStore } from '../stores/user';
import { useBoardStore } from '../stores/board';
import { onBeforeMount, onMounted, ref, computed } from 'vue';
import { useRouter } from "vue-router";
import { useRoute } from "vue-router";

const route =useRoute()
const store = useUserStore()
const bstore= useBoardStore()
const router = useRouter()
onBeforeMount (() => {
    bstore.getSearchResult(route.params.search)
})

</script>

<style scoped>

</style>