import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router'
import axios from 'axios'

const REST_USER_API = `http://localhost:8080/user`
const REST_RESULT_API = `http://localhost:8080/result`
const REST_WAIT_API = `http://localhost:8080/wait`

export const useUserStore = defineStore('user', () => {

  const login = ref(localStorage.getItem('loginUser') == null)
  const getLogin = function(){
    login.value=localStorage.getItem('loginUser') == null
  }

  const male = ref([])
  const getMaleUser = function () {
    axios.get(REST_USER_API+"/musers")
      .then((response) => {
      male.value = response.data
    })
  }

  const female = ref([])
  const getFemaleUser = function () {
    axios.get(REST_USER_API+"/fusers")
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
    findMyRanking()
    router.push("/user")
  }

  const findMyRanking = function () {
    if (oneuser.ranking == null || oneuser.ranking == 0) {
      if (oneuser.value.gender == "남자") {
        console.log(male)
        male.value.forEach(m => {
          if (m.loginId == oneuser.value.loginId) {
            oneuser.value.ranking = m.ranking;
          }
        })
      } else {
        female.value.forEach(f => {
          if (f.loginId == oneuser.value.loginId) {
            oneuser.value.ranking = f.ranking;
          }
        })
      }
    }
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
    axios.get(REST_WAIT_API+"/accept/"+receiverId.value)
    .then((response) => {
      receivedRequestList.value = response.data
    })
  }

  const sentRequestList = ref({})
  const senderId = ref("");
  const getSentRequestList = function () {
    senderId.value = JSON.parse(localStorage.getItem('loginUser')).loginId
    axios.get(REST_WAIT_API+"/send/"+senderId.value)
    .then((response) => {
      sentRequestList.value = response.data
    })
  }

  const beforeGetOneUser = async function (loginId) {
    await axios.get(REST_USER_API+"/"+loginId).then((response) => {
      // waitOneUser.value = response.data
      // getOneUser(waitOneUser);
      oneuser.value = response.data
    })
    findMyRanking()
    router.push("/user")
  }

  // const makeMyPage = async function (loginId) {
  //   await axios.get(REST_USER_API+"/"+loginId).then((response) => {
  //     oneuser.value = response.data
  //   })
  //   findMyRanking()
  // }

  const myId = ref("");
  const yourId = ref("");
  const me = ref({});
  const you = ref({});

  const nowMatching = ref({})
  const getNowMatching = async function () {
    myId.value = JSON.parse(localStorage.getItem('loginUser')).loginId
    await axios.get(REST_RESULT_API+"/now/"+myId.value)
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
    axios.get(REST_RESULT_API+"/"+myId.value)
    .then((response) => {
      pastMatching.value = response.data
    })
  }

  const userPastMatching = ref([])
  const getUserPastMatching = function () {
    axios.get(REST_RESULT_API+"/"+oneuser.value.loginId)
    .then((response) => {
      userPastMatching.value = response.data
    })
  }

  const matchUser1 = ref({})
  const matchUser2 = ref({})
  const getMatchUser = function (loginId1, loginId2) {
    axios.get(REST_USER_API+"/"+loginId1).then((response) => {
      matchUser1.value = response.data
    })
    axios.get(REST_USER_API+"/"+loginId2).then((response) => {
      matchUser2.value = response.data
    })
  }

  return {login, getLogin, male, getMaleUser, female, getFemaleUser, oneuser, getOneUser, 
    searchList, getSearchResult, receiverId, receivedRequestList, getReceivedRequestList, senderId, sentRequestList, getSentRequestList,
    myId, yourId, me, you, makeYourId, nowMatching, getNowMatching, pastMatching, getPastMatching, matchUser1, matchUser2, getMatchUser, findMyRanking,
    userPastMatching, getUserPastMatching, beforeGetOneUser}
})