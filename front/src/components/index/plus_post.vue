<template>
    <b-button
        variant="outline-success"
        @click="goTo"
        block
        style="width: 70vw; max-width: 550px;"
        class="my-5 mx-auto"
        v-b-tooltip.hover
        title="Добавить новый пост"
    >Добавить пост</b-button>
</template>

<script>
    export default {
        name: "plus_post",
        methods: {
            goTo() {
                this.$router.push('/add_post')
            }
        }
    }
</script>