import React from "react";
import { Switch,Route } from "react-router-dom";
import Login from "../pages/Login";
import ProductList from "../pages/ProductList";
import Register from "../pages/Register";
import Product from "../pages/Product";
import Cart from "../pages/Cart";
export default function Dashboard() {
  return (
    <div>
      <Switch>
        <Route path="/products" component={ProductList} />
        <Route path="/allProducts" component={ProductList} />
        <Route path="/cart" component={Cart} />
        <Route path="/product/:id" component={Product} />
        <Route path="/register" component={Register} />
        <Route path="/login" component={Login} />
      </Switch>
       
    </div>
  );
}
