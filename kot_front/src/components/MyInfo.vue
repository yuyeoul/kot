<template>
    <div id="myinfo-div">
        <h2>나의 정보</h2>
        <div id="contents">
            <div id="profile-img">
                <img src="@/assets/profile.png" style="width: 200px; border-radius: 50%;">
            </div>
            <div>
                이름 : {{ loginUser.name }} <br>
                성별 : {{ loginUser.gender }} <br>
                나이 : {{ loginUser.age }} <br>
                주소 : {{ loginUser.address }} <br>
                핸드폰 번호 : {{ loginUser.phone }}
            </div>
        </div>
    </div>
</template>

<script setup>
import axios from "axios"
import { useUserStore } from "@/stores/user";
import { onBeforeMount, onMounted, ref } from "vue";
import { useRouter } from "vue-router";

const store = useUserStore()
const router = useRouter()

const loginUser = JSON.parse(localStorage.getItem('loginUser'));

onMounted(() => {
    
})
</script>

<style scoped>
h2 {
    font-family: MaplestoryLight;
}

#myinfo-div {
    display: flex;
    flex-direction: column;
}

#contents {
    display: flex;
    flex-direction: row;
    margin: 30px 0 0 0 ;
}

#profile-img {
    margin: 0 50px 0 0;
}
</style>