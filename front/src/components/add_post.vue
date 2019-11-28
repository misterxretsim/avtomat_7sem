<template>
    <center>
        <div class="add_post" @click="openModal">
            <b>+</b>
        </div>
    </center>
</template>

<script>
    export default {
        name: "add_post",
        methods: {
            openModal() {
                this.$store.commit('changeModal')
            }
        }
    }
</script>

<style scoped>
    .add_post {
        font-size: 30px;
        color: lightgrey;
        border: 1px solid lightgrey;
        border-radius: 50%;
        width: 40px;
        cursor: pointer;
        transition: .3s;
    }
    .add_post:hover {
        color: grey;
    }
</style>