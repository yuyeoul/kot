<template>
    <div class="container">
        <div id="side-bar" class="col-2">
            <h3>마이페이지</h3>
            <div class="make-inline">
                <RouterLink to="/mypage" class="custom-link">나의 정보</RouterLink>
            </div>
            <div class="make-inline">
                <RouterLink to="/upass" class="custom-link">비밀번호 변경</RouterLink>
            </div>
            <div class="make-inline">
                <RouterLink to="/receive" class="custom-link2">우편함</RouterLink>
            </div>
            <div class="make-inline">
                <RouterLink to="/now" class="custom-link">진행중인 매칭</RouterLink>
            </div>
            <div class="make-inline">
                <RouterLink to="/past" class="custom-link">과거 매칭기록</RouterLink>
            </div>
        </div>
        <div id="main-contents" class="col-10">
            <RouterView />
        </div>
    </div>
</template>

<script setup>

</script>

<style scoped>
.custom-link.router-link-exact-active {
    background: linear-gradient(to top, rgb(198, 255, 171) 50%, transparent 50%);
    border-radius: 5px;
}

h3 {
    font-family: MaplestoryLight;
}

.custom-link2.router-link-active {
    background: linear-gradient(to top, rgb(198, 255, 171) 50%, transparent 50%);
    border-radius: 5px;
}

#side-bar {
    display: flex;
    flex-direction: column;
}

#side-bar,
#main-contents {
    margin: 50px 0 0 0 ;
}
.container {
    display: flex;
    flex-direction: row;
}

.make-inline {
    display: inline;
    font-family: MaplestoryLight;
}

a:hover {
    background: linear-gradient(to top, rgb(198, 255, 171) 50%, transparent 50%);
    border-radius: 5px;
}
a {
    text-decoration: none;
    color: black;
}
</style>