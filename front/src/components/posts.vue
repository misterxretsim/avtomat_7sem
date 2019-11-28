<template>
    <center>
        <div v-for="post in this.$store.getters.posts" :key="post.id" class="post-container">
            <close :post_id="post.id"></close>
            <h3>{{post.name}}</h3>
            <h5>
                {{post.body}}
            </h5>
        </div>
        <b-card v-for="post in this.$store.getters.posts" :key="post.id" :title="post.name">
            <b-card-text>
                {{post.body}}
            </b-card-text>
        </b-card>
    </center>
</template>

<script>
    import close from './close.vue'

    export default {
        name: "posts",
        components: {
            close
        }
    }
</script>

<style scoped>
    .post-container {
        border: 1px solid lightgrey;
        border-radius: 5px;
        width: 60vw;
        margin: 15px;
        position: static;
    }
</style>