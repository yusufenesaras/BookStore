import styled from "styled-components";
import { mobile } from "../responsive";
import BookService from "../service/BookService";
import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { Table } from "@material-ui/core";
import { useParams } from "react-router";

const Container = styled.div`
  flex: 1;
  margin: 3px;
  height: 70vh;
  position: relative;
`;

const Image = styled.img`
  width: 100%;
  height: 100%;
  object-fit: cover;
  ${mobile({ height: "20vh" })}
`;

const Info = styled.div`
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`;

const Title = styled.h1`
  color: white;
  margin-bottom: 20px;
`;

const Button = styled.button`
  border: none;
  padding: 10px;
  background-color: white;
  color: gray;
  cursor: pointer;
  font-weight: 600;
`;

const CategoryItem = ({ item }) => {
  let { id } = useParams();

  const [books, setBooks] = useState([]);

  useEffect(() => {
    let bookService = new BookService();
    bookService.getByCategory(id).then((result) => setBooks(result.data.data));
  }, [id]);

  return (
    <Container>
      <Image src={item.img} />
      <Info>
        <Title>{item.title}</Title>
        {/* {books.map((book) => (
          <Button as={Link} to={`/products/${book.category.categoryId}`}>
            Go To Category
          </Button>
        ))} */}
      </Info>
    </Container>
  );
};

export default CategoryItem;
