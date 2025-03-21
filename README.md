### Hexlet tests and linter status:
[![Actions Status](https://github.com/miskaris-wq/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/miskaris-wq/java-project-71/actions)

https://asciinema.org/a/6fQPc1ojcaqSYf17XK49F1YEo
https://asciinema.org/a/zGAMMvyEJ00TTCcZnt7qB4Uzd
https://asciinema.org/a/5ijYenrNNWnyGAJcWBwtyfmFp
https://asciinema.org/a/IhnMiwd7xHIh2Y5Uu1aynR5J8


[![Maintainability](https://api.codeclimate.com/v1/badges/e8f7dae9a71a67aea0c5/maintainability)](https://codeclimate.com/github/miskaris-wq/java-project-71/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/e8f7dae9a71a67aea0c5/test_coverage)](https://codeclimate.com/github/miskaris-wq/java-project-71/test_coverage)

# java-project-71: Hexlet Project - Difference calculator

## Description

This repository contains a Java project completed as part of the Hexlet training program. The project is a utility for comparing two files (JSON or YAML) and outputting the differences in various formats.

## Project Goal

The main goal of the project is to demonstrate Java programming skills, including:

* Working with files and parsing data (JSON, YAML).
* Implementing algorithms for comparing data structures.
* Generating reports in different formats (stylish, plain, json).
* Code organization and modularity.

## Functionality

The project supports the following features:

File Comparison: The utility can compare two files in JSON or YAML formats.

Output Formats:

    Stylish: A visually appealing output with indentation and colors.

    Plain: A simple text-based output.

    JSON: Output in JSON format.

Nested Structure Support: The utility correctly handles nested objects and arrays.

## How to Use

1.  Clone the repository:

    ```
    git clone https://github.com/miskaris-wq/java-project-71.git
    cd java-project-71
    ```

2.  Build the project (using Make):

    ```
    make build
    ```

3.  Run the project (via Make):

    ```
    make run
    ```
4. Example of using:

    ```
    ./gendiff --format plain path/to/file1.json path/to/file2.yml
    ```

## Requirements

*   Java 11 or higher.
*   Make installed (for building and running with `make build` and `make run` commands).

## Dependencies

The project has no external dependencies other than the standard Java library.

## Authors

*   miskaris-wq

## Acknowledgments

Thanks to Hexlet for the educational program and the provided platform for developing this project.
