<template>
  <div>
      <TennisHeader />
      <RouterView class="router-contents" />
      <TennisFooter />
  </div>
</template>

<script setup>
import TennisHeader from '@/components/TennisHeader.vue'
import TennisFooter from '@/components/TennisFooter.vue'
</script>

<style scoped>
@import url('https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css');

.router-contents {
  min-height: calc(100vh - 520px);
}

* {
  /* font-family: MaplestoryLight; */
  font-size: 1.2rem;
  font-weight: 700;
  /* background-color: rgb(240,240,240); */
}

@font-face {
font-family:'MaplestoryLight';
src: url('assets/MaplestoryLight.ttf') format('truetype');
font-weight: 700;
}
</style>