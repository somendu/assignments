module.exports = {
  outputDir: '../TaskList/src/main/resources/static',
  transpileDependencies: ['vue-octicon'],
  configureWebpack: {
    devtool: 'source-map'
  },
  devServer: {
    port: 8090,
    proxy: {
      '/api': {
        target: 'http://localhost:9000',
        changeOrigin: true
      }
    }
  }
};
