<template>
    <div>
        <table class="my-info table table-hover">
            <thead>
                <tr>
                    <th></th>
                    <th></th>
                    <th></th>
                    <td></td>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>{{ bstore.onearti.title }}</td>
                    <td>{{ bstore.onearti.userId }}</td>
                    <td>{{ bstore.onearti.regdate }}</td>
                    <td>{{ bstore.onearti.content }}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script setup>
import axios from 'axios';
import { useUserStore } from '../stores/user';
import { onBeforeMount, onMounted, ref, computed } from 'vue';
import { useRouter } from "vue-router";
import { useBoardStore } from '../stores/board';

const bstore = useBoardStore()
const router = useRouter()


</script>

<style scoped>

</style>