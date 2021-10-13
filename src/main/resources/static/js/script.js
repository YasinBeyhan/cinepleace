Vue.component('testZwei', {
    template: `

`,
})


var app = new Vue({
    el: '#app',


    data: {
        return: {

            Cats: [
                {name: 'KingKong'},
                {name: 'Godzilla'}

            ],
            newCat: ''

        },


        methods: {
            addKitty: function () {
                return this.Cats.push({name: this.newCat})

            }


        }
    }
})