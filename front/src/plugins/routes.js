const routes = [
    {
        path: '/',
        name: 'posts',
        component: () => import('../views/home.vue')
    },
    {
        path: '/add_post',
        name: 'add_post',
        component: () => import('../views/add_post.vue')
    }
];
export default routes;