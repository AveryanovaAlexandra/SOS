// @ts-nocheck
import { RouteRecordRaw } from "vue-router"

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'list',
    alias: '/list',
    component: () => import('@/views/List.vue'),
  },
  {
    path: '/add',
    component: () => import('@/views/Add.vue'),
  },
  {
    path: '/books/:id',
    component: () => import('@/views/Edit.vue'),
    props: (route) => {
      const id = Number.parseInt(route.params.id);
      return {id}
    }
  },
  {
    path: '/admin',
    component: () => import('@/views/Admin.vue'),
    props: (route) => {
      const id = Number.parseInt(0);
      return {id}
    }
  },
]

export default routes
