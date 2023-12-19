<template>
  <div class="make-center">
    <div class="login-area">
      <h2>로그인</h2>
      <div class="login-input-boxes">
			  <div class="mb-3">
				  <input type="hidden" name="act" value="login">
				  <label for="id" class="form-label">아이디</label>
				  <div class="underline-input">
					  <input type="text" placeholder="아이디" v-model="loginId" @keyup.enter="login()">
				  </div>
			  </div>
			  <div class="mb-3">
				  <label for="pass" class="form-label">비밀번호</label>
				  <div class="underline-input">
					  <input type="password" placeholder="비밀번호" v-model="pass" @keyup.enter="login()">
				  </div>
			  </div>
      </div>

      <div id="bottom-login-box">
        <div id="login-btn-area">
			    <button @click="login" class="btn btn-success">로그인</button>
        </div>
        <div id="go-sign-up">
          아직 회원이 아니신가요?
          <RouterLink to="/signup">회원가입 하러 가기</RouterLink>
        </div>
      </div>

    </div>
  </div>

</template>

<script setup>
import axios from "axios";
import { ref } from "vue";
import { useRouter } from "vue-router";
import { useUserStore } from "@/stores/user";
const store = useUserStore();
const loginId = ref("");
const pass = ref("");
const router = useRouter();
const login = function () {
  
  const user = {
    loginId: loginId.value,
    pass: pass.value,
  };
  axios.post("http://localhost:8080/user/login", user).then((res) => {
    console.log(res.data.length)
    if (res.data.length == 0) {
      alert("로그인 실패!")
      router.push('/login')
    } else {
      localStorage.setItem("loginUser", JSON.stringify(res.data));
      store.getLogin()
      router.push('/').then(() => {
        location.reload();
      });
    }
  })
    
};
</script>

<style scoped>
h2 {
  font-family: MaplestoryLight;
}

#login-btn-area {
  display: flex;
  justify-content: right;
}
.login-area {
  display: inline-block;
  justify-content: flex-start;
  /* border: solid gray 1px; */
  border-radius: 10px;
  box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.3);
  margin: 50px 100px;
  padding: 20px 40px 20px 20px;
  height: 320px;
}

.mb-3 {
  display: flex;
  flex-direction: row;
}

.mb-3 label {
  width: 100px;
  display: flex;
  justify-content: flex-end;
  padding: 0 10px 0 0;
}

.login-input-boxes {
  display: flex;
  flex-direction: column;
  margin: 20px 0 0 0;
}

/* #bottom-login-box {
  display: flex;
  flex-direction: row;
  align-content: center;
} */

#go-sign-up {
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
  align-items: flex-end;
  font-size: 1rem;
  margin: 20px 0 0 0;
}

.make-center {
    display: flex;
    justify-content: center;
}

input {
  border: 0;
  background-color: lightgray;
  border-radius: 5px;
  padding: 3px 10px;
}

a {
  color: black;
  text-decoration: none;
  background: linear-gradient(to top, rgb(198, 255, 171) 50%, transparent 50%);
}

a:hover {
  background: linear-gradient(to top, rgb(218, 255, 201) 50%, transparent 50%);
  border-radius: 5px;
}
</style>