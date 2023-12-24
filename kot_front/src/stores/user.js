import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router'
import axios from 'axios'

const REST_USER_API = `http://localhost:8080/user`
const REST_RESULT_API = `http://localhost:8080/matchresult`
const REST_WAIT_API = `http://localhost:8080/matchwait`

export const useUserStore = defineStore('user', () => {

  const login = ref(localStorage.getItem('loginUser') == null)
  const getLogin = function(){
    login.value=localStorage.getItem('loginUser') == null
  }

  const male = ref([])
  const getMaleUser = function () {
    axios.get(REST_USER_API+"/male")
      .then((response) => {
      male.value = response.data
    })
  }

  const female = ref([])
  const getFemaleUser = function () {
    axios.get(REST_USER_API+"/female")
      .then((response) => {
      female.value = response.data
    })
  }

  const oneuser = ref({})
  const getOneUser = function (user) {
    if (localStorage.getItem('loginUser') == null) {
      alert("로그인이 필요합니다.")
      router.push("/login")
      return;
    }
    oneuser.value = user
    router.push("/user")
  }



  const searchList = ref([])
  const getSearchResult = function (search) {
    if (search == "") {
      console.log(search)
      alert("검색어를 입력해주세요.");
      return;
    }
    axios.get(REST_USER_API+"/search/"+search)
    .then( (response) => {
      searchList.value = response.data
      router.push("/search/"+search)
    })
  }

  const receivedRequestList = ref([])
  const receiverId = ref("");
  const getReceivedRequestList = function () {
    receiverId.value = JSON.parse(localStorage.getItem('loginUser')).loginId
    axios.get(REST_WAIT_API+"/received/"+receiverId.value)
    .then((response) => {
      receivedRequestList.value = response.data
    })
  }

  const sentRequestList = ref({})
  const senderId = ref("");
  const getSentRequestList = function () {
    senderId.value = JSON.parse(localStorage.getItem('loginUser')).loginId
    axios.get(REST_WAIT_API+"/sent/"+senderId.value)
    .then((response) => {
      sentRequestList.value = response.data
    })
  }

  const beforeGetOneUser = async function (loginId) {
    await axios.get(REST_USER_API+"/"+loginId).then((response) => {
      oneuser.value = response.data
    })
    findMyRanking()
    router.push("/user")
  }


  const myId = ref("");
  const yourId = ref("");
  const me = ref({});
  const you = ref({});

  const nowMatching = ref({})
  const getNowMatching = async function () {
    myId.value = JSON.parse(localStorage.getItem('loginUser')).loginId
    await axios.get(REST_RESULT_API+"/"+myId.value)
    .then((response) => {
      nowMatching.value = response.data;
    })
    makeYourId();

    // user1 user2 나랑 너 구분해주기

    // myId에 현재 로그인 유저의 로그인아이디가 저장되어있음
    // yourId에 상대방 유저의 로그인아이디가 저장되어있음
    
  }

  const makeYourId = function () {

    if (myId.value == nowMatching.value.user1) {
      yourId.value = nowMatching.value.user2;

      me.value = {
          id: nowMatching.value.user1,
          name: nowMatching.value.user1Name,
          phone: nowMatching.value.user1Phone,
      }
      you.value = {
          id: nowMatching.value.user2,
          name: nowMatching.value.user2Name,
          phone: nowMatching.value.user2Phone,
      }

    } else {
      yourId.value = nowMatching.value.user1;

      me.value = {
          id: nowMatching.value.user2,
          name: nowMatching.value.user2Name,
          phone: nowMatching.value.user2Phone,
      }
      you.value = {
          id: nowMatching.value.user1,
          name: nowMatching.value.user1Name,
          phone: nowMatching.value.user1Phone,
      }
    }
  }

  const pastMatching = ref([])
  const getPastMatching = function () {
    myId.value = JSON.parse(localStorage.getItem('loginUser')).loginId
    axios.get(REST_RESULT_API+"/past/"+myId.value)
    .then((response) => {
      pastMatching.value = response.data
    })
  }

  const userPastMatching = ref([])
  const getUserPastMatching = function () {
    axios.get(REST_RESULT_API+"/past/"+oneuser.value.loginId)
    .then((response) => {
      userPastMatching.value = response.data
    })
  }

  const matchUser1 = ref({})
  const matchUser2 = ref({})
  const getMatchUser = function () {
    

    axios.get(REST_USER_API+"/selectuser",{
      params: {
        loginId:nowMatching.value.user1,
        gender:JSON.parse(localStorage.getItem('loginUser')).gender
      }
    }).then((response) => {
      matchUser1.value = response.data
    })
    axios.get(REST_USER_API+"/selectuser",{
      params: {
        loginId:nowMatching.value.user2,
        gender:JSON.parse(localStorage.getItem('loginUser')).gender
      }
    }).then((response) => {
      matchUser2.value = response.data
    })
  }

  return {login, getLogin, male, getMaleUser, female, getFemaleUser, oneuser, getOneUser, 
    searchList, getSearchResult, receiverId, receivedRequestList, getReceivedRequestList, senderId, sentRequestList, getSentRequestList,
    myId, yourId, me, you, makeYourId, nowMatching, getNowMatching, pastMatching, getPastMatching, matchUser1, matchUser2, getMatchUser,
    userPastMatching, getUserPastMatching, beforeGetOneUser}
})