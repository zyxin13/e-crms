define(["backbone"],
    function (Backbone) {
        var Routers = Backbone.Router.extend({
            initialize: function () {
                console.log("Route initialize");
                // Backbone.history.start({pushState: true});
                Backbone.history.start();
            },
            // Hash maps for routes
            routes: {
                "": "index",
                "login": "login",
                "main": "main",
                "*error": "fourOfour"
            },

            index: function () {
                this.navigate('login', {trigger: true, replace: true});
            },

            login: function () {
                alert("login page");
            },

            main: function () {
                alert("main page");
            },

            fourOfour: function (error) {
                // 404 page
                alert(error);
            }
        });
        return Routers;
    });
