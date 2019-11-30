import resource from '../../../mixins/resource'

export default {
    actions: {
        getPosts(ctx) {
            resource.post({method: 'get'})
                .then((resp) => ctx.commit('updatePosts', resp))
                .catch((e) => alert(`error ${JSON.stringify(e)}`))
                // {
                //     id: 1,
                //     author: 'Marina Kuzmina',
                //     date: '26.10.2019',
                //     title: 'Укрепление волос',
                //     body: 'После того, как помыла голову, подсушила их на 40% естественным путём и потом наношу кератиновую водичку от Estel на ещё не расчесанные волосы.'
                // },
                // {
                //     id: 2,
                //     author: 'Marina Kuzmina',
                //     date: '01.09.2019',
                //     title: 'Масло лаванды',
                //     body: 'C лавандовым маслом хорошо принимать ванны, они будут обладать двойным эффектом – ухаживать за кожей и успокаивать нервы, привлекая сон.'
                // },
                // {
                //     id: 3,
                //     author: 'Marina Kuzmina',
                //     date: '22.08.2019',
                //     title: 'Поговорим о коже',
                //     body: 'Самый верхний слой кожи - роговой, и он меняется достаточно быстро. Можно его увлажнить, отшелушить, сгладить и все это быстро отразится на вашем внешнем виде кожи.'
                // },
                // {
                //     id: 4,
                //     author: 'Nikolay Kolesnik',
                //     date: '10.07.2019',
                //     title: 'Мармарис',
                //     body: 'А вы знали, что Мармарис расположен на границе Средиземного моря с Эгейским? Город растянулся вдоль бухты, вокруг которой зеленые горы и яркая тропическая растительность.'
                // },
        },
        deletePost(ctx, id) {
            resource.post({method: 'delete', post: {id: id}})
                .then((resp) => ctx.commit('updatePosts', resp))
                .catch((e) => alert(`error ${e}`))
        },
        addPost(ctx, post) {
            resource.post({method: 'add', post: post})
                .then((resp) => ctx.commit('updatePosts', resp))
                .catch((e) => alert(`error ${e}`))
        }
    },
    mutations: {
        updatePosts(state, posts) {
            state.posts = posts.body.book
        }
    },
    state: {
        posts: []
    },
    getters: {
        posts: (state) => state.posts
    }
}