<template>
   <div>
        <div id="male-ranking">
            <h2>글목록</h2>
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
                    <tr v-for="arti in bstore.article" :key="arti" @click="bstore.getOneArticle(arti)">
                        <td>{{ arti.boardId }}</td>
                        <td>{{ arti.title }}</td>
                        <td>김이박</td>
                        <td>{{ formatDate(arti.regdate) }}</td>
                        <td>{{ arti.view}}</td>
                    </tr>
                </tbody>
            </table>
        </div>  
    <div>
        <RouterLink to="/boardwrite">글쓰기</RouterLink> | 
    </div>
   </div>
</template>

<script setup>
import axios from 'axios';
import { useUserStore } from '../stores/user';
import { useBoardStore } from '../stores/board';
import { onBeforeMount, onMounted, ref, computed } from 'vue';
import { useRouter } from "vue-router";


const ustore = useUserStore()
const bstore = useBoardStore()
const router = useRouter()

const formatDate = function (matchDate) {
    const newMatchDate = new Date(matchDate);
    return newMatchDate.toLocaleDateString();
}
onMounted(() => {
    bstore.getArticle()
    
})

</script>

<style scoped>

</style>