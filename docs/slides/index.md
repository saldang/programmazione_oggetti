---
layout: page
title: Slides
permalink: /slides/
---

## {{page.title}}

{% for slide in site.static_files %}
Prova:
{{ slide.path }}
{% endfor %}
