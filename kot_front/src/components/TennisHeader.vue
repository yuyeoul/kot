<template>
  <div>
    <div>
			<header>
				<nav>
					<RouterLink to="/"><img src="@/assets/tennis_logo_gpt.png" style="width: 80px"></RouterLink>
            <!-- <h1>KING of TENNIS</h1> -->
					<div class="menu-bar">
            <!--로그인 전-->
            <div class="before-login" v-if="store.login">
              <RouterLink to="/login">로그인</RouterLink> | 
              <RouterLink to="/signup">회원가입</RouterLink>
            </div>
            <div class="after-login" v-else>
              {{ loginUserName  }}님 | 
              <RouterLink to="/mypage">마이페이지</RouterLink> | 
              <a @click="logout">로그아웃</a>
            </div>
					</div>
				</nav>
        <div class="header-img">
          <img src="@/assets/tenni.jpg">
        </div>
			</header>
		</div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRouter } from "vue-router";
import { useUserStore } from "@/stores/user";
import axios from "axios";
const store = useUserStore();

const router = useRouter();
const login = ref(false);

const loginUser = JSON.parse(localStorage.getItem('loginUser'));
const loginUserName = loginUser !== null ? loginUser.name : null;

const isLogin = () => {
  login.value = localStorage.getItem('loginUser') == null;
};
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

onMounted(isLogin);
</script>

<style scoped>
nav {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    padding: 10px;
    font-family: MaplestoryLight;
}

.menu-bar a:hover {
  background: linear-gradient(to top, rgb(198, 255, 171) 50%, transparent 50%);
  border-radius: 5px;
}
a {
  text-decoration: none;
  color: black;
}


.header-img {
  max-height: 300px;
  overflow: hidden;
}

.header-img img {
  width: 100%;
}
</style>