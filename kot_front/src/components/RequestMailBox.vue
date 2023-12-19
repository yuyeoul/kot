<template>
    <div>
        <div class="rs-select">
            <RouterLink to="/receive" class="custom-link">받은 요청</RouterLink> | 
            <RouterLink to="/send" class="custom-link">보낸 요청</RouterLink>
        </div>
        <RouterView />
    </div>
</template>

<script setup>

</script>

<style scoped>
a {
    font-family: MaplestoryLight;
    text-decoration: none;
    color: black;
}
a:hover {
  transition: 1s;
  background-color: rgb(206, 206, 206);
  border-radius: 5px;
}
.custom-link.router-link-exact-active {
    background: linear-gradient(to top, rgb(198, 255, 171) 50%, transparent 50%);
    border-radius: 5px;
}
</style>