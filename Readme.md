## Text Processor

1. Sort lines of text alphabetically in ascending or descending order (supported order aliases are `asc` and `desc`).

   `text-processor sort --input-file <input-file> --output-file <output-file> --order <order>`

2. Ability to remove duplicate lines from a text file.

   `text-processor dedup --input-file <input-file> --output-file <output-file>`

3. Ability to search for specific text within a file and return the line numbers where it appears.
   
   `text-process search --input-file <input-file> --search-text <search-text>`

4. Ability to replace a specific text within a file with new text.
   
   `text-processor replace --input-file <input-file> --output-file <output-file> --search-text <search-text> --replace-text <replace-text>`

5. Ability to merge two or more text files into a single file. Input file must space separated.
   
   `text-processor merge --input-files <input-files> --output-file <output-file>`

