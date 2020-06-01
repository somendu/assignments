<template>
  <table class="lineage" border="1">

   
	  <div> Somendu </div>
 

  </table>
</template>

<script>

 

export default {
  name: 'SaveTask',

  components: {
     
  },


  data () {
    return {
      products: ['Boots', 'Socks', 'Tie'],
      messages: ['hello', 'vue', 'js'],
      shoppingItems: [
        {name: 'apple', price: '10'},
      {name: 'orange', price: '12'}]
    };
  },

  computed: {
    totalProducts () {
      return this.products.reduce((sum, product) => {
        return sum + product.quantity;
      }, 0);
    }
  },

  created () {
    fetch('https://api.myjson.com/bins/74l63')
      .then(response => response.json())
      .then(json => {
        this.products = json.products;
      });
  }
  
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
