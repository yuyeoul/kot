<template>
    <div class="container">
        <div class="avobe-match-plate">
            <div class="rs-select">
                <RouterLink to="/now">진행중인 매칭</RouterLink> | 
                <RouterLink to="/past">과거 경기 기록</RouterLink>
            </div>
        </div>
        <div class="match-plate">
            <RouterView />
        </div>
    </div>
</template>

<script setup>

</script>

<style scoped>
a:hover {
    background: linear-gradient(to top, rgb(198, 255, 171) 50%, transparent 50%);
    border-radius: 5px;
}
a {
    display: inline;
    text-decoration: none;
    color: black;
}
</style>