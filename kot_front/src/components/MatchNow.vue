<template>
    <div>
        <h2 id="title">진행중인 매칭 정보</h2>
        <div v-show="store.nowMatching.id != null">
            <div class="players">
            <div class="player col-6">
                <h3 id="player1-me">나</h3>
                <div class="player-info" id="player1">
                    <div>
                        <img src="@/assets/profile.png" style="width: 200px; border-radius: 50%;">
                    </div>
                    <div>
                        <p>이름 : {{ store.me.name }}({{ store.me.id }})</p>
                        <p>연락처 : {{ store.me.phone }}</p>
                    </div>
                </div>
            </div>
            <div class="player col-6">
                <h3 id="player2-you">상대방</h3>
                <div class="player-info" id="player2">
                    <div>
                        <p>이름 : {{ store.you.name }}({{ store.you.id }})</p>
                        <p>연락처 : {{ store.you.phone }}</p>
                    </div>
                    <div>
                        <img src="@/assets/profile.png" style="width: 200px; border-radius: 50%;">
                    </div>
                </div>
            </div>
        </div>
        <div id="bottom">
            <div class="record col-6">
                <p>해당 플레이어와의 전적 : {{ opponentPastMatching.length }}전 {{ winCount }}승 {{ opponentPastMatching.length - winCount }}패</p>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>날짜</th>
                            <th>경기결과</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="pastmatch in opponentPastMatching" :key="pastmatch">
                            <td>{{ formatDate(pastmatch.fDate) }}</td>
                            <td>{{ matchWinner(store.you.id, pastmatch.result) }}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="put-match-result col-6">
                <!--달력-->
                <div class="date-picker">
                    <v-date-picker mode="date" @dayclick="finishDate" />
                </div>
                <!--라디오버튼-->
                <label for="winner" class="form-label">승자</label>
                <div class="select-winner">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" :value="store.nowMatching.user1" v-model="result">
                        <label class="form-check-label" for="flexRadioDefault1">
                            {{ store.nowMatching.user1Name }}({{ store.nowMatching.user1 }})
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" :value="store.nowMatching.user2" v-model="result">
                        <label class="form-check-label" for="flexRadioDefault1">
                            {{ store.nowMatching.user2Name }}({{ store.nowMatching.user2 }})
                        </label>
                    </div>
                </div>
                <button class="btn btn-success" @click="sendResult">결과전송</button>
            </div>
        </div>
    </div>
    <div v-show="store.nowMatching.id == null" class="no-contents">
        <h2>진행중인 매칭이 없어요!</h2>
        <div id="make-inline">
            <RouterLink to="/">신청해볼까?</RouterLink>
        </div>
    </div>
</div>
</template>

<script setup>
import axios from 'axios';
import { useUserStore } from '../stores/user';
import { onBeforeMount, onMounted, ref, computed } from 'vue';
import { useRouter } from "vue-router";


const store = useUserStore()
const router = useRouter()

const formatDate = function (matchDate) {
    const newMatchDate = new Date(matchDate);
    return newMatchDate.toLocaleDateString();
}



const newRate = function (u1Rate, u2Rate) {
    // user1이 이길 확률
    const expectedWinRate = 1/(Math.pow(10,(u2Rate-u1Rate)/400)+1)
    // 승자는 result.value로 접근 가능
    const rateChange1 = 50*(1-expectedWinRate)
    const rateChange2 = 50*expectedWinRate;

    if (result.value == store.nowMatching.user1) {
        // user1이 이겼으면?
        u1Rate +=rateChange1;
        u2Rate -=rateChange1;
    } else {
        // user2가 이겼으면?
        u1Rate -=rateChange2;
        u2Rate +=rateChange2;
    }

    return {rate1: u1Rate, rate2: u2Rate}
}

const date = ref("")
const finishDate = (day, event) => {
  date.value = day.id;
};
const result = ref("")

const sendResult = function () {
    
    const madeNewRate = newRate(store.matchUser1.rate, store.matchUser2.rate)

    const user1data = {
        loginId: store.matchUser1.loginId,
        rate: madeNewRate.rate1,
    }
    const user2data = {
        loginId: store.matchUser2.loginId,
        rate: madeNewRate.rate2,
    }

    axios.put("http://localhost:8080/user/user1", user1data).then((response) => {

    })
    axios.put("http://localhost:8080/user/user2", user2data).then((response) => {

    })  

    const sendContent = {
        id: store.nowMatching.id,
        fDate: date.value,
        result: result.value,
    }
    const users={
        user1:store.nowMatching.user1,
        user2:store.nowMatching.user2,
    }
    axios.put("http://localhost:8080/result", sendContent).then((res) => {
        alert("경기 결과가 저장되었습니다.");
        axios.put("http://localhost:8080/result/end",users).then((ress)=>{

        })
        // user 테이블에 접근해서 rate 변경하기 (ELO 써서 해보자)
        router.go(0)
    })
}

const opponentPastMatching = ref([])
const getOPMatching = function () {
    const users = {
        user1: store.nowMatching.user1,
        user2: store.nowMatching.user2,
    }
    axios.post("http://localhost:8080/result/past", users).then((res) => {
        opponentPastMatching.value = res.data
    })
}

const matchWinner = function (opponent, winner) {
    if (opponent == winner) {
        return "패"
    } else {
        return "승";
    }
}

const winCount = computed (() => {
    let win = 0;
    opponentPastMatching.value.forEach(match => {
        if (store.you.id != match.result) {
            win++;
        }
    });
    return win;
})

onBeforeMount(async () => {
    await store.getNowMatching()
    getOPMatching()
    store.getMatchUser(store.nowMatching.user1, store.nowMatching.user2)
})

onMounted(() => {
   
})

</script>

<style scoped>
h2, h3 {
    font-family: MaplestoryLight;
}

h2#title {
    margin-bottom: 40px;
}
h3 {
    margin-bottom: 20px;
}
.players {
    display: flex;
    flex-direction: row;
}

.player-info {
    display: flex;
    flex-direction: row;
}

h3#player2-you {
    text-align: right;
    vertical-align: top;
}

#player2.player-info {
    justify-content: right;
}


#player1 img {
    margin-right: 30px;
}

#player2 img {
    margin-left: 30px;
}

#player1 p {
    justify-content: flex-start;
    text-align: left;
}

#player2 p {
    justify-content: flex-end;
    margin-left: auto;
    text-align: right;
}

p {
    text-align: center;
}

#bottom {
    display: flex;
    margin-top: 50px;
}

.record {
    margin-right: 20px;
}

.date-picker {
    margin-bottom: 20px;
}

.put-match-result {
    margin-left: 20px;
}

.select-winner {
    display: flex;
    flex-direction: row;
    margin-bottom: 15px;
}

.form-check-input {
    margin-right: 10px;
}

.form-check-label {
    width: 140px;
}

.no-contents {
    display: flex;
    flex-direction: column;
    justify-content: center;
    text-align: center;
}

#make-inline {
    display: inline;
}

a {
  color: black;
  text-decoration: none;
  background: linear-gradient(to top, rgb(198, 255, 171) 50%, transparent 50%);
}

a:hover {
  background: linear-gradient(to top, rgb(218, 255, 201) 50%, transparent 50%);
  border-radius: 5px;
}
</style>