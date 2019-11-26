<template>
    <div class="home">
        <center>
            <h1 class="mb-5 mt-3">Posts:</h1>
        </center>
        <posts/>
    </div>
</template>

<script>
    import posts from '../components/index/posts.vue'

    export default {
        name: 'home',
        components: {
            posts
        }
    }
</script>