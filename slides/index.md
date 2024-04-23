---
layout: page
title: Slides
permalink: /slides/
---

## {{page.title}}

{% assign slides=site.static_files | where_exp: "item", "item.path contains 'pdfs/'" %}

{% for slide in slides %}

- [{{ slide.name }}]({{site.baseurl}}{{slide.path}})
  {% endfor %}
