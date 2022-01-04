import styled from "styled-components";
import { categories } from "../data";
import { mobile } from "../responsive";
import CategoryItem from "./CategoryItem";
import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { Table } from "@material-ui/core";
import { useParams } from "react-router";
import BookService from "../service/BookService";


const Container = styled.div`
  display: flex;
  padding: 20px;
  justify-content: space-between;
  ${mobile({ padding: "0px", flexDirection:"column" })}
`;


const Categories = () => {
//   let { id } = useParams();

// const [books, setBooks] = useState([]);

// useEffect(() => {
//   let bookService = new BookService();
//   bookService.getByCategory(id).then((result) => setBooks(result.data.data));
// }, [id]);

  return (
    <Container>
      {categories.map((item) => (
        <CategoryItem item={item} key={item.id} />
      ))}

    </Container>
  );
};

export default Categories;