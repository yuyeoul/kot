<template>
    <div class="make-center">
        <div class="signup-area">
			<h2>회원가입</h2>
            <div class="signup-input-boxes">
                <div class="mb-3">
                    <label for="name" class="form-label">이름</label>
                    <div class="underline-input">
                        <input type="text" placeholder="이름" v-model="name">
                    </div>
                </div>
                <div class="mb-3">
                    <label for="id" class="form-label">아이디</label>
                    <div class="underline-input">
                        <input type="text" placeholder="아이디" v-model="loginId">
                        &nbsp;&nbsp;<button class="btn btn-secondary btn" @click="idCheck(loginId)">체크</button>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="pass" class="form-label">비밀번호</label>
                    <div class="underline-input">
                        <input type="password" placeholder="비밀번호" v-model="pass">
                    </div>
                </div>
                <div class="mb-3">
                    <label for="pass" class="form-label">비밀번호 확인</label>
                    <div class="underline-input" style="display: flex; flex-direction: row; align-items: center;">
                        <input type="password" placeholder="비밀번호 확인" v-model="passCheck">
                        &nbsp;&nbsp;<h6 v-show="(pass.length > 0) && (pass == passCheck)" style="color: green;">일치</h6>
                        <h6 v-show="(pass != passCheck)" style="color: red;">불일치</h6>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">이메일</label>
                    <div class="underline-input">
                        <input type="email" placeholder="이메일" v-model="email">
                    </div>
                </div>
                <div class="mb-3">
                    <label for="phone" class="form-label">핸드폰 번호</label>
                    <div class="underline-input">
                        <input type="text" placeholder="핸드폰 번호" v-model="phone">
                        &nbsp;&nbsp;<button class="btn btn-secondary btn" @click="phoneCheck(phone)">체크</button>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="gender" class="form-label">성별</label>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" value="남자" v-model="gender">
                        남자&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" value="여자" v-model="gender">
                        여자
                    </div>
                    <!-- <input type="text" placeholder="사용자의 성별을 입력하세요" v-model="gender"> -->
                </div>
                <div class="mb-3">
                    <label for="age" class="form-label">나이</label>
                    <div class="underline-input">
                        <input type="text" placeholder="나이" v-model="age">
                    </div>
                </div>
                <div class="mb-3">
                    <label for="address" class="form-label">주소</label>
                    <div class="underline-input">
                        <input disabled type="text" placeholder="주소" id="address" v-model="address">
                    </div>
                    &nbsp;&nbsp;<button @click="showApi()" class="btn btn-secondary btn">검색</button>
                </div>
                <div id="signup-btn">
                    <button @click="signUp" class="btn btn-success">회원가입</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import axios from "axios";
import { ref, registerRuntimeCompiler } from "vue";
import { useRouter } from "vue-router";

const router = useRouter();
const loginId = ref("");
const name = ref("");
const email = ref("");
const pass = ref("");
const passCheck = ref("");
const age = ref("");
const gender = ref("");
const phone = ref("");
const address = ref("");

const idCheckResult = ref({
    boolean: false,
    id: ""
})
const idCheck = function (newId) {
    axios.get("http://localhost:8080/user/"+newId).then((response) => {
        console.log(response.data)
        if (response.data.length == 0) {
            // OK
            alert("사용 가능한 아이디입니다.")
            idCheckResult.value.boolean = true;
            idCheckResult.value.id = newId;
        } else {
            // 새로운 아이디 입력하세요
            alert("이미 존재하는 아이디입니다.")
        }
    })
}


const phoneCheckResult = ref({
    boolean: false,
    phone: ""
})
const phoneCheck = function (newPhone) {
    axios.get("http://localhost:8080/user/check/"+newPhone).then((response) => {
        if (response.data.length == 0) {
            alert("사용 가능한 핸드폰 번호입니다.")
            phoneCheckResult.value.boolean = true;
            phoneCheckResult.value.phone = newPhone;
            console.log(phoneCheckResult.value.phone)
        } else {
            alert("이미 가입한 핸드폰 번호입니다.")
        }
    })
}

const showApi = () => {
  new window.daum.Postcode({
    oncomplete: (data) => {
        address.value=data.roadAddress;
        },
      }).open();
};


const signUp = function () {
  const user = {
    loginId: loginId.value,
    name: name.value,
    email: email.value,
    pass: pass.value,
    age: age.value,
    gender: gender.value,
    phone: phone.value,
    address: address.value,
  };

  if (idCheckResult.value.boolean && phoneCheckResult.value.boolean) {
    // 둘 다 true이고,
    if (idCheckResult.value.id == user.loginId && phoneCheckResult.value.phone == user.phone) {
        // 혹시라도 그새 바꿨는지 마지막으로 확인하고
        if (pass.value == passCheck.value) {
            // 비밀번호랑 비밀번호 확인이랑 같은지도 확인하고
        } else {
            alert("비밀번호 확인 다시해")
            return;
        }
    } else {
        alert("아이디 혹은 핸드폰 번호 중복체크 다시해")
        return;
    }
  } else {
    alert("중복체크 안했잖아")
    return;
  }

  axios.post("http://localhost:8080/user/signup", user).then((res) => {
	alert("회원가입이 완료되었습니다.");
    router.push("/");
  });
};
</script>

<style scoped>
h2 {
    font-family: MaplestoryLight;
}

#signup-btn button {
    position: relative;
    left: 120px;
}

.signup-input-boxes {
  display: flex;
  flex-direction: column;
  margin: 20px 0 0 0;
}

.signup-input-boxes .btn-success {
    width: 270px;
}

/* input {
  border: 0;
  background-color: lightgray;
  border-radius: 5px;
  padding: 3px 10px;
}

.mb-3 {
    display: flex;
    flex-direction: row;
} */

input {
  border: 0;
  background-color: lightgray;
  border-radius: 5px;
  padding: 3px 10px;
  flex: 1; /* 수정: input box가 남은 공간을 채우도록 설정 */
}

.mb-3 {
  display: flex;
  flex-direction: row; /* 수정: 요소들을 가로로 나열 */
  align-items: center; /* 추가: 요소들을 수직 중앙 정렬 */
  margin-bottom: 15px;
}

.mb-3 label {
  width: 140px;
  display: flex;
  justify-content: flex-end;
  padding: 0 10px 0 0;
}

.signup-area {
  display: inline-block;
  justify-content: flex-start;
  /* border: solid gray 1px; */
  border-radius: 10px;
  box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.3);
  margin: 50px 100px;
  padding: 20px 40px 20px 20px;
}

.make-center {
    display: flex;
    justify-content: center;
}
</style>