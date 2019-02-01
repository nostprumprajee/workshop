module.exports = {
  /*
   ** Headers of the page
   */
  mode: 'spa',
router: {
  mode: 'hash'
},
  render: {
    resourceHints: false,
  },
  head: {
    title: "workshop",
    meta: [
      { charset: "utf-8" },
      { name: "viewport", content: "width=device-width, initial-scale=1" },
      { hid: "description", name: "description", content: "test" }
    ],
    link: [{ rel: "icon", type: "image/x-icon", href: "/favicon.ico" },
    { rel: 'stylesheet', href: 'https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Material+Icons' }
  ]
    
  },
  /*
   ** Customize the progress bar color
   */
  loading: { color: "#3B8070" },
  
  css: ['~/assets/main.styl'],
  plugins: ['~/plugins/vuetify'],

  /*
   ** Build configuration
   */

  build: {
    vendor: ['vuetify'],
    /*
     ** Run ESLint on save
     */
    extend(config, { isDev, isClient }) {
      if (isDev && isClient) {
        config.module.rules.push({
          enforce: "pre",
          test: /\.(js|vue)$/,
          loader: "eslint-loader",
          exclude: /(node_modules)/
        });
      }
    }
  }
};
