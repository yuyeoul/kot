import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router'
import axios from 'axios'

const REST_BOARD_API = `http://localhost:8080/board`
const REST_REPLY_API = `http://localhost:8080/reply`


export const useBoardStore = defineStore('board', () => {
    const article=ref([])
    const getArticle=function(){
        axios.get(REST_BOARD_API+"/").then((response) => {
            article.value = response.data
          })
    }

    const onearti = ref({})
    const getOneArticle = function (arti) {
    onearti.value = arti
    router.push("/boarddetail")
    }

    const searchList = ref([])
    const getSearchResult = function (search) {
    if (search == "") {
      console.log(search)
      alert("검색어를 입력해주세요.");
      return;
    }
    axios.get(REST_BOARD_API+"/search/"+search)
    .then( (response) => {
      searchList.value = response.data
      router.push("/bsearch/"+search)
        })
    }

  return {article,getArticle,onearti,getOneArticle,searchList,getSearchResult}
})