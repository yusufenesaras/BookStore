import styled from "styled-components";
import Announcement from "../components/Announcement";
import BookService from "../service/BookService";
import React, { useState, useEffect } from "react";
import { mobile } from "../responsive";
import { useParams } from "react-router";
const Container = styled.div``;

const Wrapper = styled.div`
  padding: 50px;
  display: flex;
  ${mobile({ padding: "10px", flexDirection: "column" })}
`;

const ImgContainer = styled.div`
  flex: 1;
`;

const Image = styled.img`
  width: 100%;
  height: 90vh;
  object-fit: cover;
  ${mobile({ height: "40vh" })}
`;

const InfoContainer = styled.div`
  flex: 1;
  padding: 0px 50px;
  ${mobile({ padding: "10px" })}
`;

const Title = styled.h1`
  font-weight: 200;
`;

const Desc = styled.p`
  margin: 20px 0px;
`;

const Price = styled.span`
  font-weight: 100;
  font-size: 40px;
`;

const FilterContainer = styled.div`
  width: 50%;
  margin: 30px 0px;
  display: flex;
  justify-content: space-between;
  ${mobile({ width: "100%" })}
`;

const Filter = styled.div`
  display: flex;
  align-items: center;
`;

const FilterTitle = styled.span`
  font-size: 20px;
  font-weight: 200;
`;

const FilterSize = styled.select`
  margin-left: 10px;
  padding: 5px;
`;

const FilterSizeOption = styled.option``;

const AddContainer = styled.div`
  width: 50%;
  display: flex;
  align-items: center;
  justify-content: space-between;
  ${mobile({ width: "100%" })}
`;

const AmountContainer = styled.div`
  display: flex;
  align-items: center;
  font-weight: 700;
`;

const Button = styled.button`
  padding: 15px;
  border: 2px solid teal;
  background-color: white;
  cursor: pointer;
  font-weight: 500;
  &:hover {
    background-color: #f8f4f4;
  }
`;

const Product = () => {
  let { id } = useParams();

  const [books, setBooks] = useState([]);

  useEffect(() => {
    let bookService = new BookService();
    bookService.findById(id).then((result) => setBooks(result.data.data));
  }, [id]);

  return (
    <Container>
      <Announcement />
      {books.map((book) => (
        <Wrapper key={book.category?.categoryId}>
          <ImgContainer>
              <div>
                <Image
                  key={book.bookId}
                  className="imgZoom"
                  src={book.bookImageUrl}
                  style={{
                    width: "500px",
                    height: "500px",
                    objectFit: "cover",
                    borderRadius: "20px",
                    cursor: "zoom-in",
                  }}
                  alt="hangImage"
                />
              </div>
            </ImgContainer>
          <InfoContainer>
            <Title>{book.name}</Title>
            <Desc>{book.summary}</Desc>
            <Price>$ 20</Price>
            <FilterContainer>
              <Filter>
                <FilterTitle>Category: </FilterTitle>
                <FilterTitle>{book?.category.categoryName}</FilterTitle>
              </Filter>
              <Filter>
                <FilterTitle>Page</FilterTitle>
                <FilterSize>
                  <FilterSizeOption>{book.numPages}</FilterSizeOption>
                </FilterSize>
              </Filter>
            </FilterContainer>
            <AddContainer>
              <AmountContainer>
                {/* <FilterTitle>Author: </FilterTitle> */}
                <FilterTitle>
                  {book?.publisher.publisherName} Publisher
                </FilterTitle>
              </AmountContainer>
              <Button>ADD TO CART</Button>
            </AddContainer>
          </InfoContainer>
        </Wrapper>
      ))}
    </Container>
  );
};

export default Product;
