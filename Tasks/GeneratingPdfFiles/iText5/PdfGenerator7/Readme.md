What is iText?
iText is an SDK that was developed to allow developers to do the following (and much more):

Generate documents and reports based on data from an XML file or a database
Create maps and books, exploiting numerous interactive features available in PDF
Add bookmarks, page numbers, watermarks, and other features to existing PDF documents
Split or concatenate pages from existing PDF files
Fill out interactive forms
Digitally sign PDF documents
Serve dynamically generated or manipulated PDF documents to a web browser
iText is not an end-user tool. You have to build iText into your own applications so that you can automate the PDF creation and manipulation process.

When to use iText?
Typically, iText is used in projects that have one of the following requirements:

The content isn't available in advance: it's calculated based on user input or real-time database information.
The PDF files can't be produced manually due to the massive volume of content: a large number of pages or documents.
Documents need to be created in unattended mode, in a batch process.
The content needs to be customized or personalized; for instance, the name of the end user has to be stamped on a number of pages.
Often you'll encounter these requirements in web applications, where content needs to be served dynamically to a browser. Normally, you'd serve this information in the form of HTML, but for some documents, PDF is preferred over HTML for better printing quality, for identical presentation on a variety of platforms, for security reasons, to comply with specific industry standards (such as PAdES, PDF/A, or PDF/UA), or to reduce the file size.


But now, itext7 is preffered to use not itext5 due to more compatibility issue.
