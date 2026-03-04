import Vue from 'vue';
import VueRouter from 'vue-router';
import Cookies from 'js-cookie'
import Login from '../views/LoginPage.vue';
import LayoutPage from '../components/LayoutPage.vue';
import StudentInfo from '../views/StudentInfo.vue';
import CourseSelect from '../views/CourseSelect.vue';
import MyCourses from '../views/MyCourses.vue';
import { Message } from 'element-ui';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login
  },
  {
    path: '/',
    component: LayoutPage,
    redirect: '/students',
    children: [
      {
        path: 'students',
        name: 'Students',
        component: StudentInfo
      },
      {
        path: 'course-select',
        name: 'CourseSelect',
        component: CourseSelect
      },
      {
        path: 'my-courses',
        name: 'MyCourses',
        component: MyCourses
      }
    ]
  }
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

// 简单的路由守卫，未登录拦截
router.beforeEach((to, from, next) => {
  const studentInfo = Cookies.get('studentInfo');
    if (to.path === '/') {
    next()
  } else {
    // 访问其他页面必须登录
    if (studentInfo) {
      next()
    } else {
      Message.warning('请先登录')
      next('/')
    }
  }

})

export default router;