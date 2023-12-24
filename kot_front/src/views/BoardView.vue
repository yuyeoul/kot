<template>
   
</template>

<script setup>
import axios from 'axios';
import { useUserStore } from '../stores/user';
import { onBeforeMount, onMounted, ref, computed } from 'vue';
import { useRouter } from "vue-router";


const store = useUserStore()
const router = useRouter()


</script>

<style scoped>

</style>