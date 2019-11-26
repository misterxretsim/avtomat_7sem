<template>
    <div id="app">
        <b-navbar type="dark" variant="dark" sticky>
            <b-navbar-nav class="mx-auto">
                <b-nav-item :active="locationIs('/')" to="/">Posts</b-nav-item>
                <b-nav-item :active="locationIs('/add_post')" to="/add_post">Add Post</b-nav-item>
                <b-nav-item disabled>Settings</b-nav-item>
            </b-navbar-nav>
        </b-navbar>
        <router-view></router-view>
    </div>
</template>

<script>
    export default {
        methods: {
            locationIs(path) {
                return path === location.pathname
            }
        },
        created() {
            this.$store.dispatch('getPosts')
        }
    }
</script>

<style>
    body {
        background: #FAF5FF;
    }
</style>