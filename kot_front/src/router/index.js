import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import Rank from '@/components/Rank.vue'
import SearchResult from '@/components/SearchResult.vue'
import MyPageView from '@/views/MyPageView.vue'
import MyInfo from '@/components/MyInfo.vue'
import UserView from '@/views/UserView.vue'
import LoginView from '@/views/LoginView.vue'
import SignUpView from '@/views/SignUpView.vue'
import RequestMailBox from '@/components/RequestMailBox.vue'
import RequestReceive from '@/components/RequestReceive.vue'
import RequestSend from '@/components/RequestSend.vue'
import MatchNow from '@/components/MatchNow.vue'
import MatchPast from '@/components/MatchPast.vue'
import UpdatePass from '@/components/UpdatePass.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,

      children: [
        {
          path: '/',
          name: 'rank',
          component: Rank
        },
        {
          path: '/search/:search',
          name: 'search',
          component: SearchResult
        }
      ]
    },
    {
      path: '/mypage',
      name: 'mypage',
      component: MyPageView,

      children: [
        {
          path: '/mypage',
          name: 'myinfo',
          component: MyInfo,
        },
        {
          path: '/upass',
          name: 'upass',
          component: UpdatePass,
        },
        {
          path: '/receive',
          name: 'mailbox',
          component: RequestMailBox,

          children: [
            {
              path: '/receive',
              name: 'receive',
              component: RequestReceive
            },
            {
              path: '/send',
              name: 'send',
              component: RequestSend
            }
          ]
        },
        {
          path: '/now',
          name: 'matchnow',
          component: MatchNow
        },
        {
          path: '/past',
          name: 'matchpast',
          component: MatchPast
        }
      ]
    },
    {
      path: '/user',
      name: 'user',
      component: UserView
    },
    {
      path: '/login',
      name: 'login',
      component: LoginView
    },
    {
      path: '/signup',
      name: 'signup',
      component: SignUpView
    }
  ]
})

export default router
