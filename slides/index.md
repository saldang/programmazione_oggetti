---
layout: page
title: Slides
permalink: /slides/
---

## {{page.title}}

{% assign slides=site.static_files | where_exp:"slide","slide.path contains 'assets'" | sort: "name" %}

{% for slide in slides %}

- [{{ slide.name }}]({{site.baseurl}}{{slide.path}})
  {% endfor %}

Inspect:
{{ slides | inspect }}
