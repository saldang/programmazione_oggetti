---
layout: page
title: Slides
permalink: /slides/
---

## {{page.title}}

{% assign slides=site.static_files | where_exp:"slide","slide.path contains 'assets'" | sort: 'name' %}
Inspect:
{{ slides | inspect }}

{% for slide in slides %}

- [{{ slide.name }}]({{site.baseurl}}{{slide.path}})
  {% endfor %}
