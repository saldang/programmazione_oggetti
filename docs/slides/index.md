---
layout: page
title: Slides
permalink: /slides/
---

## {{page.title}}

{% assign pdf_files = site.static_files | where: "pdf", true %}
{% for slide in pdf_files %}
{{ slide.path }}
{% endfor %}
