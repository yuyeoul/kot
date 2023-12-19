<template>
    <div>
        <h2>비밀번호 변경</h2>
        <div class="mb-3">
        <label for="nowpass" class="form-label">현재 비밀번호</label>
            <div class="underline-input">
                <input type="password" placeholder="현재 비밀번호" v-model="nowPass">
            </div>
        </div>
        <div class="mb-3">
            <label for="newpass" class="form-label">변경할 비밀번호</label>
            <div class="underline-input">
                <input type="password" placeholder="변경할 비밀번호" v-model="newPass">
            </div>
        </div>
        <div class="mb-3">
            <label for="newpasscheck" class="form-label">변경할 비밀번호 재확인</label>
            <div class="underline-input">
                <input type="password" placeholder="변경할 비밀번호 재확인" v-model="newPassCheck" @keyup.enter="checkNowPass()">
                    &nbsp;&nbsp;<h6 v-show="(newPass.length > 0) & (newPass == newPassCheck)" style="color: green;">일치</h6>
                    <h6 v-show="(newPass != newPassCheck)" style="color: red;">불일치</h6>
            </div>
        </div>
        <button class="btn btn-success btn" @click="checkNowPass()">변경하기</button>


    

    </div>
</template>

<script setup>
import axios from "axios";
import { ref } from "vue";
import { useRouter } from "vue-router";
const router=useRouter()

const nowPass=ref("")
const newPass=ref("")
const newPassCheck=ref("")
const checkNowPass=function(){
    const userInfo={
        loginId:JSON.parse(localStorage.getItem('loginUser')).loginId,
        pass:newPass.value,
    }
    console.log(userInfo.pass)
    if(nowPass.value==JSON.parse(localStorage.getItem('loginUser')).pass){
            axios.put('http://localhost:8080/user/upass',userInfo).then()
            alert("비밀번호 변경이 완료 되었습니다.")
            logout();
    }else{
        alert("비밀번호를 다시 확인 하세요")
    }
}


const logout = () => {
	axios.get("http://localhost:8080/user/logout")
    .then(() => {
      localStorage.removeItem('loginUser');
      router.push('/').then(() => {
        location.reload();
      });
    })
    .catch(error => {
      console.error("Logout failed:", error);
    });
};
</script>

<style scoped>
input {
  border: 0;
  background-color: lightgray;
  border-radius: 5px;
  padding: 3px 10px;
  flex: 1; /* 수정: input box가 남은 공간을 채우도록 설정 */
  width: 250px;
}

h2 {
    font-family: MaplestoryLight;
    margin-bottom: 20px;
}
</style>