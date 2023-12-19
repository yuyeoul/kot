<template>
    <div class="ranking">
        <div id="male-ranking">
            <h2>남자 랭킹</h2>
    
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>순위</th>
                        <th>이름</th>
                        <th>점수</th>
                        <th>매칭현황</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="male in store.male" :key="male" @click="store.getOneUser(male)">
                        <td v-if="male.ranking == 1">{{ male.ranking }} 👑</td>
                        <td v-else>{{ male.ranking }}</td>

                        <td>{{ male.name }}</td>
                        <td>{{ male.rate }}</td>
                        <td v-if="male.status">경기중</td>
                        <td v-else>신청가능</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="female-ranking">
            <h2>여자 랭킹</h2>

            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>순위</th>
                        <th>이름</th>
                        <th>점수</th>
                        <th>매칭현황</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- <tr v-for="female in FemaleUsers" @click="store.getOneUser(female)"> -->
                    <tr v-for="female in store.female" :key="female" @click="store.getOneUser(female)">
                        <td v-if="female.ranking == 1">{{ female.ranking }} 👑</td>
                        <td v-else>{{ female.ranking }}</td>
                        <td>{{ female.name }}</td>
                        <td>{{ female.rate }}</td>
                        <td v-if="female.status">경기중</td>
                        <td v-else>신청가능</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>

<script setup>
import { useUserStore } from "@/stores/user";
import { onMounted, ref } from "vue";

const store = useUserStore()

onMounted(() => {
    store.getMaleUser()
    store.getFemaleUser()
})

</script>

<style scoped>
h2 {
    font-family: MaplestoryLight;
}

.ranking {
    display: flex;
    justify-content: flex-start;
}

#male-ranking,
#female-ranking {
    flex: 1; /* 동일한 비율로 테이블 영역을 나눕니다. */
    /* border: 1px solid black; */
}

#male-ranking {
    margin: 10px 30px 10px 0;
}
#female-ranking {
    margin: 10px 0 10px 30px;
}
</style>