<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
    <html lang="en">

    <head>
        <title>IS Google Scholar</title>
    </head>

    <body>
        <link rel="stylesheet" type="text/css" href="style.css">

        <main>

            <center>
                <h1>IS Google Scholar</h1>
            </center>

            <div class="row1">
                <section id="Researchers">
                    <header>
                        <h4>Researchers on the database</h4>
                    </header>
                    <article>
                        <p>
                            <c:forEach var="item" items="${researchers}">
                                <div>${item}</div>
                            </c:forEach>
                        </p>
                    </article>
                </section>
            </div>


            <div class="row2">
                <section id="Publications">
                    <header>
                        <h4>Publications</h4>
                    </header>
                    <article>
                        <p>
                            <c:forEach var="item" items="${publications}">
                                <div>${item}</div>
                            </c:forEach>
                        </p>
                        <p id="pub"></p>
                    </article>
                </section>
            </div>


        </main>
    </body>

    </html>