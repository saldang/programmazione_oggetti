---
layout: page
title: Slides
permalink: /slides/
---

## {{page.title}}

Here are the slides for the course. They are in PDF format.

{% for slide in site.static_files %}
{% if slide.path contains 'assets' %}

- [{{ slide.name }}]({{site.baseurl}}{{slide.path}})
{% endif %}
{% endfor%}
<!-- 
{% assign pdf_files = site.static_files | where: "pdf", true %}
{% for slide in pdf_files %}


- [{{ slide.name }}]({{ slide.path }})

{% endfor %} -->
